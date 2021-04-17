# kafka-demo

Ejemplo simple de generacion de consumidor y productor con particiones
Se encuentra en el directorio config los archivos properties con los valores para el ejemplo

### Configuracion inicial

* Iniciar zookeeper

```console
zookeeper-server-start.sh config/zookeeper.properties
```

* Iniciar Kafka Server (3 kafka servers)

```console
kafka-server-start.sh config/server0.properties
```
```console
kafka-server-start.sh config/server1.properties
```
```console
kafka-server-start.sh config/server2.properties
```

* Crear un topic (topic name: topic5) con 10 particiones y un factor de replicacion de 3

```console
export CONFIG_FILE=config/client.properties
export BOOTSTRAP_SERVERS="localhost:9092,localhost:9192,localhost:9292"
kafka-topics.sh --bootstrap-server ${BOOTSTRAP_SERVERS} --command-config ${CONFIG_FILE} --create --replication-factor 3 --partitions 10 --topic topic5
kafka-topics.sh --bootstrap-server ${BOOTSTRAP_SERVERS} --command-config ${CONFIG_FILE} --list
```

**Puede configurar los puertos del cluster o modificar parametros en IKafkaConstants.java si es necesario.**

### Para correr el demo

* Ejecutar un consumidor por medio de:

```console
java -cp kafkademo-1.0-jar-with-dependencies.jar ec.jtux.kafkademo.main.MainConsumer
```

* Ejecutar un productor por medio de:

```console
java -cp kafkademo-1.0-jar-with-dependencies.jar ec.jtux.kafkademo.main.MainProducer
```

**Con la finalidad de validar el funcionamiento del particionamiento debe correr multilples consumidores.**