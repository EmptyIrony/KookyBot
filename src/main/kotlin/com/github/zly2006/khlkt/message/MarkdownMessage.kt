/* KhlKt - a SDK of <https://kaiheila.cn> for JVM platform
Copyright (C) <year>  <name of author>

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published
by the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.*/

package com.github.zly2006.khlkt.message

import com.github.zly2006.khlkt.client.Client
import com.github.zly2006.khlkt.contract.Channel

class MarkdownMessage(
    client: Client,
    var content: String
) : Message(client) {
    override fun content(): String = this.content
    override fun send2Channel(channel: Channel) {
        client.sendChannelMessage(target = channel, content = content())
    }
}