package com.example.jarvis_app_v_real.websocket_connection

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import okhttp3.*
import okio.ByteString.Companion.toByteString
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.TimeUnit

object AudioWebSocketManager {

    private const val RECORDER_SAMPLERATE = 44100
    private val RECORDER_CHANNELS: Int = AudioFormat.CHANNEL_IN_STEREO
    private val RECORDER_AUDIO_ENCODING: Int = AudioFormat.ENCODING_PCM_16BIT

    private var audioRecord: AudioRecord? = null
    private val BUFFER_SIZE_RECORDING = AudioRecord.getMinBufferSize(
        RECORDER_SAMPLERATE,
        RECORDER_CHANNELS,
        RECORDER_AUDIO_ENCODING
    ) * 4

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    private val request = Request.Builder().url("ws://192.168.56.1:7890").build()

    private var webSocket: WebSocket? = null

    fun initialize(coroute: CoroutineScope) {
//        initAudioRecorder()
        initWebSocket()
//        record(coroute)
    }

    @SuppressLint("MissingPermission")
    private fun initAudioRecorder() {
        audioRecord = AudioRecord(
            MediaRecorder.AudioSource.MIC,
            RECORDER_SAMPLERATE, RECORDER_CHANNELS,
            RECORDER_AUDIO_ENCODING, BUFFER_SIZE_RECORDING
        )

        if (audioRecord?.state == AudioRecord.STATE_INITIALIZED) {
            audioRecord?.startRecording()
            println("IN12345678")
        } else {
            // Handle initialization failure
            Timber.e("AudioRecord initialization failed with state")
            println("ERROR")
        }
    }

    private fun initWebSocket() {
        webSocket = okHttpClient.newWebSocket(request, object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                super.onOpen(webSocket, response)
                Timber.d("WebSocket opened")
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                super.onMessage(webSocket, text)
                // Handle incoming WebSocket messages
                println(text)
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                super.onFailure(webSocket, t, response)
                Timber.e(t, "WebSocket failure")
            }
        })
    }

    private fun record(coroutineScope: CoroutineScope) {
        val buf = ByteArray(BUFFER_SIZE_RECORDING)
        coroutineScope.launch {
            try {
                do {
                    val byteRead = audioRecord?.read(buf, 0, buf.size) ?: break
                    if (byteRead < -1)
                        break
                    webSocket?.send(buf.toByteString(0, byteRead))
                } while (true)
            } catch (e: Exception) {
                Timber.e(e, "Error during recording")
                stop()
            }
        }
//        coroutineScope.launch {
//            try {
//                do {
//                    val byteRead = audioRecord?.read(buf, 0, buf.size) ?: break
//                    if (byteRead < -1)
//                        break
//                    webSocket?.send(buf.toByteString(0, byteRead))
//                } while (true)
//            } catch (e: Exception) {
//                Timber.e(e, "Error during recording")
//                stop()
//            }
//        }
    }

    fun stop() {
        webSocket?.cancel()
        audioRecord?.stop()
        audioRecord?.release()
        audioRecord = null
        Timber.d("Recording stopped")
    }
}

// Usage example:
fun main() {
//    AudioWebSocketManager.initialize()

    // Do other tasks or wait for user input

//    AudioWebSocketManager.stop()
}
