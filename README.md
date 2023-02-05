# How to manage objects

## Serialization
> In computing, serialization (or serialisation) is the process of translating a data structure or object state into a format that can be stored (e.g. files in secondary storage devices, data buffers in primary storage devices) or transmitted (e.g. data streams over computer networks) and reconstructed later (possibly in a different computer environment)

definition by [Wikipedia](https://en.wikipedia.org/wiki/Serialization) 

I would like to change this a bit 

### Serious serialization
Avro, Cryo, Java native serialization.

Data are transformed into binary format, humans can't read it.

Information about the schema is stored in the binary format. No class information are lost (if you wont use "Transient" or similar option)

### Human readable serialization
JSON, YAML, XML, CSV, ...

Data is stored in "text" and humans can read it (if you know the schema) and alter with a text editor.
Information about schema is usually lost.

Simple example of json

```json
{
  "name": "John",
  "age": 30,
  "cars": [
    { "name":"Ford", "models":[ "Fiesta", "Focus", "Mustang" ] },
    { "name":"BMW", "models":[ "320", "X3", "X5" ] },
    { "name":"Fiat", "models":[ "500", "Panda" ] }
  ]
}
```

Are models java list, array, set? You can use different data structures on both sides. 


## [Avro](https://avro.apache.org/)
### [Getting started](https://avro.apache.org/docs/1.11.1/getting-started-java/)
(side note - manual in maven, no gradle... maybe apache does not like gradle?)



#### [Schema](https://avro.apache.org/docs/1.11.1/spec.html#schemas)


How to manage your objects and schemas
