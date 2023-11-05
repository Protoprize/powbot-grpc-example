# PowBot GRPC Impl Example

This repo contains a basic implementation for using GRPC with PowBot

## Requirements 
- A GRPC server - Tons of tutorials online and is pretty simple/quick to setup.

## Tutorial

1. Make sure your .proto files in `src/main/proto` reflect those used on your server
2. To generate Protobuf stubs, run the `generateProto` task: `.\gradlew :generateProto`
	This will generate the sources into `src/main/generated`

3. Implement your services and RPC calls. Example can be found [here](https://github.com/Protoprize/powbot-grpc-example/blob/main/src/main/java/com/proto/script/services/ExampleService.kt) 

4. To send a request:

	```kotlin
	GlobalScope.launch {  
	  val call = exampleService.exampleRpcCall(request)  
	    logger.debug("Response: ${call.success}")  
	}
	```
