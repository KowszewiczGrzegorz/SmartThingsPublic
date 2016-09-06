/**
 *  MyStreams
 *
 *  Copyright 2014 Grzegorz Kowszewicz
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
definition(
    name: "Presence",
    namespace: "Grz",
    author: "Grz",
    description: "Log to PresenceSensor",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")

preferences {
    section("Log devices...") {
		input "presenceSensor", "capability.presenceSensor", title: "Presence Sensor", required: false, multiple: true
    }

    section ("IPs you want to monitor...") {
        input "IP1", "text", title: "IP1"
        input "IP2", "text", title: "IP2"
    }
}

def updated() {
    log.debug "Going through updated.."
    unsubscribe()
    unschedule()
    initialize()
}

def initialize() {
    log.debug "Going through initialize.."
    subscribe(presenceSensor, "presence", eventHandler)
    schedule("0/1 * * * * ?", checkPresence)
    log.debug "Initialization.. done"
    checkPresence()
}

def eventHandler(evt) {
    queueValue(evt) { it.toString() }
}

def checkPresence() {
 
  log.debug "Check of the presence.."
  def porthex = convertPortToHex("777")
  def hosthex = convertIPtoHex(IP1)
  
  def hostip = hosthex + ":" + porthex
  
  request = """GET / HTTP/1.1\r\nAccept: */*\r\nHost: localhost\r\n\r\n"""


            
  try {
 new physicalgraph.device.HubAction("""GET / HTTP/1.1
HOST: ${hostip}
CALLBACK: <http://${getCallBackAddress()}/>
NT: upnp:event
TIMEOUT: Second-2
User-Agent: CyberGarage-HTTP/1.0


""", physicalgraph.device.Protocol.LAN)
     } catch (Exception e) {
		log.debug "Hit Exception $e on $hubAction"
	 }
 

  log.debug "$hosthex:$porthex"
/*
   def url = "http://ef.greko.eu/charts/dane/index.php?compId=${compId}&${streamId}=${value}"
 
   log.debug "processQueue"
    if (state.queue != []) {
        log.debug "Events: ${state.queue}"

        try {
            httpPutJson([uri: url, body: state.queue ]) { 
                response -> 
                if (response.status != 200 ) {
                    log.debug "Logging failed, status = ${response.status}"
                } else {
                    log.debug "Accepted event(s)"
                    state.queue = []
                }
            }
        } catch(e) {
            def errorInfo = "Error sending value: ${e}"
            log.error errorInfo
        }
    }
    
*/
}


def parse(String output) {
  log.debug "Parse goes here.."
}

private String convertIPtoHex(ipAddress) { 
    String hex = ipAddress.tokenize( '.' ).collect {  String.format( '%02x', it.toInteger() ) }.join()
    trace("IP address entered is $ipAddress and the converted hex code is $hex")
    return hex
}

private String convertPortToHex(port) {
	String hexport = port.toString().format( '%04x', port.toInteger() )
    return hexport
}

private Integer convertHexToInt(hex) {
	Integer.parseInt(hex, 16)
}


private String convertHexToIP(hex) {
	[convertHexToInt(hex[0..1]), convertHexToInt(hex[2..3]), convertHexToInt(hex[4..5]), convertHexToInt(hex[6..7])].join(".")
}

private getHostAddress() {
	def parts = device.deviceNetworkId.split(":")
	def ip = convertHexToIP(parts[0])
	def port = convertHexToInt(parts[1])
	return ip + ":" + port
}


private trace(message) {
  log.debug message
}

private getCallBackAddress() {
  device.hub.getDataValue("localIP") + ":" + device.hub.getDataValue("localSrvPortTCP")
}
