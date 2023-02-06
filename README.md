# How to manage objects

## Serialization
> In computing, serialization (or serialisation) is the process of translating a data structure or object state into a format that can be stored (e.g. files in secondary storage devices, data buffers in primary storage devices) or transmitted (e.g. data streams over computer networks) and reconstructed later (possibly in a different computer environment)

definition by [Wikipedia](https://en.wikipedia.org/wiki/Serialization) 

I would like to change this a bit 

### Serious serialization
Java native serialization Kryo, Avro...

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

## Java Serialization
DO NOT USE IT IF YOU CAN AVOID IT!

This is the worst option. It is not human readable, it is not portable, it is not fast, it is not SECURE.
There are multiple chains of vulnerabilities in java serialization. <br>
https://snyk.io/blog/serialization-and-deserialization-in-java/ <br>
https://cheatsheetseries.owasp.org/cheatsheets/Deserialization_Cheat_Sheet.html

But... this is the easiest way to serialize objects in java, as this requires nothing special.

# [Kryo](https://github.com/EsotericSoftware/kryo)
Relatively simple library, uses similar approach as java serialization, but it is faster and produce smaller files.
It can be used for both serialization and deserialization, in one project it was used for storage data in Redis, to reduce the size of data.

One interesting feature - it supports creating deep an shallow copies of objects. <br> 
[Quick reference from Baeldung](https://www.baeldung.com/kryo)


# [Avro](https://avro.apache.org/)
## For start
### [Getting started](https://avro.apache.org/docs/1.11.1/getting-started-java/)
### [Specification and data types](https://avro.apache.org/docs/1.11.1/specification/)

## With Kafka
It can be used and with a schema registry from [Confluent](https://www.confluent.io/) it is (sometimes) used in Kafka.
### [Schema registry](https://docs.confluent.io/platform/current/schema-registry/index.html)
### [Schema evolution](https://docs.confluent.io/platform/current/schema-registry/avro.html#schema-evolution-and-compatibility)

It provides multiple ways of evolution of schemas - it gives full control of what is allowed WHEN and what is not.

It can't be called "tolerant consumer" as it is not by default.

At the same time with proper management it allows to evolve schemas in a controlled way.

# [OpenApi](https://www.openapis.org/)
## For start use [version 3.0](https://spec.openapis.org/oas/v3.0.0)
Schema definitions are NOT compatible. TAKE CARE OF IT! Version 3.0.x is now most popular.
## Why it was created?
It was created to describe REST API. It is not a serialization format, but it can be used to describe it.
## How it works?
It is a JSON file, which describes the API. It can be used to generate code, to generate documentation, to generate tests, to generate clients and servers.
## How to use it?
### [Swagger Editor](https://editor.swagger.io/)
### [Swagger Codegen](https://swagger.io/tools/swagger-codegen/)
### [Swagger UI](https://swagger.io/tools/swagger-ui/)
### Maven plugin [openapi-generator-maven-plugin]
This is NOT NICE AND SIPLE PLUGIN by no means. <br>
It uses a lot of different generators, written mainly in java + mustache templates. <br>
It is not easy to use, but it is powerful. <br>
Yet there are some A LOT of problems with it - eg. Spring Boot 3.0.x is not yet fully supported (client generation is not working properly, due to namespace change). <br>

Interesting (for us) generators:

- for generatorName = spring
    - library = spring-boot
    - library = spring-cloud
    - library = spring-http-interface
- for generatorName = java 
    - library = jersey1
    - library = jersey2
    - library = jersey3
    - library = feign
    - library = okhttp-gson
    - library = retrofit2
    - library = resttemplate
    - library = webclient
    - library = resteasy
    - library = vertx
    - library = google-api-client
    - library = rest-assured
    - library = native
    - library = microprofile
    - library = apache-httpclient

## But why?
It is a standard, it is used by many companies, it is used by many tools. <br>
It allows to have only one source of truth. <br>
It makes sharing api definition easy AND it breaks hard coupling between client and server. <br>
<b>It allows to generate code for multiple languages. <br></b>

## Types
https://swagger.io/docs/specification/data-models/data-types/ <br>

Not a lot of types are supported, but there are also formats. <br>
For example, there is a type "string" and format "date-time". <br>

# AVRO and OpenApi remark
This tools are not java specific, there are implementations in many languages but long may be different between C# and Java. <br>
This may cause problems when you want to use them together. <br>
At the same time - this problem is not unique to these tools - it is a problem of any tool which is used in different languages. <br>
YET when used wisely this is a great tool that may help managing your API and "contracts" between client and server. <br>
Best usage - java backend + angular / node fronted uses same file to generate code for both sides - nice, clean solution. <br>