package com.github.zly2006.khlkt
import com.github.zly2006.khlkt.client.Client
import kotlinx.coroutines.awaitCancellation
import java.io.File

suspend fun main() {


    if (!File("data/").exists())
        File("data/").mkdir()
    if (!File("data/token.txt").isFile) {
        File("data/token.txt").createNewFile()
        println("please fill your token in data/token/txt")
        return
    }
    var token = File("data/token.txt").readText()
    var client = Client(token)
    println(token)
    client.loginHandler = { relogin ->
        if (relogin) println("relogin success")
        else println("login success")
    }
    var self = client.connect()
    self.guilds.cachedValue?.forEach {
        it.cachedValue?.defaultChannel?.cachedValue?.sendCardMessage {
            Card {
                HeaderModule(anElement { PlainTextElement("标题") })
                SectionModule(
                    accessory = anElement { ButtonElement(text = anElement { PlainTextElement("Hello") }) },
                    text = anElement { PlainTextElement("hello") }
                )
                Divider()
                ContextModule {
                    MarkdownElement(content = "> reference\n")
                }
            }
        }
    }
    awaitCancellation()
}
