import simpy
import random
import numpy as np
import matplotlib.pyplot as plt

# Parámetros
RANDOM_SEED = 42
INTERVALOS = [0.5,1,2,3,4,10]  # Tiempos de llegada
NUM_PROCESOS = [5 ,25, 50, 100, 150, 200, 225]
RAM_CAPACIDAD = 100
CPU_VELOCIDAD = 3  # Instrucciones por unidad de tiempo
TIME = 1000  # Tiempo total de simulación

class SistemaOperativo:
    def __init__(self, env, ram_capacidad, cpu_velocidad):
        self.env = env
        self.ram = simpy.Container(env, init=ram_capacidad, capacity=ram_capacidad)
        self.cpu = simpy.Resource(env, capacity=1)
        self.cpu_velocidad = cpu_velocidad

    def ejecutar_proceso(self, proceso):
        yield self.ram.get(proceso.memoria)
        with self.cpu.request() as req:
            yield req
            while proceso.instrucciones > 0:
                yield self.env.timeout(1)
                proceso.instrucciones -= min(proceso.instrucciones, self.cpu_velocidad)
                if proceso.instrucciones > 0 and random.randint(1, 21) == 1:
                    yield self.env.timeout(1)  # Simula espera de I/O
        yield self.ram.put(proceso.memoria)
        tiempos.append(self.env.now - proceso.tiempo_llegada)

class Proceso:
    def __init__(self, env, nombre):
        self.env = env
        self.nombre = nombre
        self.instrucciones = random.randint(1, 10)
        self.memoria = random.randint(1, 10)
        self.tiempo_llegada = env.now

def generar_procesos(env, so, num_procesos, intervalo):
    for i in range(num_procesos):
        proceso = Proceso(env, 'Proceso'+ str(i))
        env.process(so.ejecutar_proceso(proceso))
        yield env.timeout(random.expovariate(1.0 / intervalo))

def ejecutar_simulacion(num_procesos, intervalo):
    global tiempos
    tiempos = []
    env = simpy.Environment()
    so = SistemaOperativo(env, RAM_CAPACIDAD, CPU_VELOCIDAD)
    env.process(generar_procesos(env, so, num_procesos, intervalo))
    env.run(until=TIME)
    return np.mean(tiempos), np.std(tiempos)

# Ejecutar simulaciones y graficar resultados
plt.figure(figsize=(10, 5))
for intervalo in INTERVALOS:
    medios, desviaciones = [], []
    for num in NUM_PROCESOS:
        media, desviacion = ejecutar_simulacion(num, intervalo)
        medios.append(media)
        desviaciones.append(desviacion)
    plt.errorbar(NUM_PROCESOS, medios, yerr=desviaciones, label='Intervalo' + str(intervalo))

plt.xlabel('Número de Procesos')
plt.ylabel('Tiempo Promedio en Sistema')
plt.title('Simulación de Procesos con SimPy')

plt.legend()
plt.show()
