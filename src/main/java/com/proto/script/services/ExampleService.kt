package com.proto.script.services


import com.proto.grpc.ExampleRpcCallRequest
import com.proto.grpc.ExampleRpcCallResponse
import com.proto.grpc.ExampleServiceGrpcKt
import io.grpc.ManagedChannelBuilder


class ExampleService {
    var channel = ManagedChannelBuilder.forAddress("localhost", 7331).usePlaintext().build()
    var service: ExampleServiceGrpcKt.ExampleServiceCoroutineStub = ExampleServiceGrpcKt.ExampleServiceCoroutineStub(channel)

    suspend fun exampleRpcCall(req: ExampleRpcCallRequest): ExampleRpcCallResponse {
        return service.exampleRpcCall(req)
    }
}