# Transport - Java

![Transport Post-merge pipeline](https://github.com/vmware/transport-java/workflows/Transport%20Post-merge%20pipeline/badge.svg)
[![codecov](https://codecov.io/gh/vmware/transport-java/branch/main/graph/badge.svg?token=JUYOqO7bYf)](https://codecov.io/gh/vmware/transport-java)

Transport is a full stack, simple, fast, expandable application event bus for your applications.

### What does that mean?

Transport is an event bus, that allows application developers to build components that can talk to one another, really easily.

It provides a standardized and simple API, implemented in multiple languages, to allow any individual component inside your applications to talk to one another.

It really comes to life when you use it to send messages, requests, responses and events around your backend and front-end. Your Java or Golang backend can stream messages to your UI components, as if they were sitting right next to each other.

Channels can be extended to major brokers like Kafka or RabbitMQ, so Transport becomes an 'on/off-ramp' for your main sources of truth.

### [View Transport Java Documentation](https://vmware.github.io/transport/java)

#### [Transport Docs Repo](https://github.com/vmware/transport)

## Quick Start
#### Run Sample App

```
./gradlew :sample-app:bootRun
```

#### Run Tests

```
./gradlew test
```

#### Build Jar

```
./gradlew jar
```

The file is output to `lib/build/libs/transport-1.0.0-SNAPSHOT.jar`

### [Read More Java Documentation](https://vmware.github.io/transport/java)

## Contributing

The transport-typescript project team welcomes contributions from the community. Before you start working with transport-typescript, please
read our [Developer Certificate of Origin](https://cla.vmware.com/dco). All contributions to this repository must be
signed as described on that page. Your signature certifies that you wrote the patch or have the right to pass it on
as an open-source patch. For more detailed information, refer to [CONTRIBUTING.md](CONTRIBUTING.md).

## License
BSD-2-Clause

Copyright (c) 2016-2021, VMware, Inc.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

