package com.proto.script

import com.proto.grpc.ExampleRpcCallRequest
import com.proto.script.services.ExampleService
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.powbot.api.Condition
import org.powbot.api.script.AbstractScript
import org.powbot.api.script.ScriptManifest
import org.slf4j.LoggerFactory

@ScriptManifest(name = "Example script", description = "Example script desc", version = "1.0", author = "Proto")
class Script: AbstractScript() {

    val logger = LoggerFactory.getLogger(Script::class.java)
    val exampleService = ExampleService()

    @OptIn(DelicateCoroutinesApi::class)
    override fun onStart() {
        val request = ExampleRpcCallRequest.newBuilder().setMessage("Hello world!").build()
        GlobalScope.launch {
            val call = exampleService.exampleRpcCall(request)
            logger.debug("Response: ${call.success}")
        }
    }
    override fun poll() {
        Condition.sleep(1000)
    }
}