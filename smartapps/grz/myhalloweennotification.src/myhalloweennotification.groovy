/**
 *  Myhalloween
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
    name: "MyHalloweenNotification",
    namespace: "Grz",
    author: "Grz",
    description: "Log to mystreams",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")

preferences {
	section("Force state update..") {
        buttons(name: "buttons", title: "required:false, multiple:false", required: false, multiple: false, buttons: [
			[label: "foo", action: "foo"],
			[label: "bar", action: "foo"]
		])
        
		input "wlaczniki", "capability.switch", multiple: true
	}

    section("Log devices...") {
		input "motionSensor", "capability.motionSensor", title: "Motion Sensor", required: false, multiple: true    
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
/* 
    subscribe(temperatures, "temperature", handleTemperatureEvent)
    subscribe(humidities, "humidity", handleHumidityEvent)
    subscribe(contacts, "contact", handleContactEvent)
    subscribe(accelerations, "acceleration", handleAccelerationEvent)
    subscribe(motions, "motion", handleMotionEvent)
    subscribe(presence, "presence", handlePresenceEvent)
    subscribe(switches, "switch", handleSwitchEvent)
    subscribe(batteries, "battery", handleBatteryEvent)
    subscribe(powers, "power", handlePowerEvent)
    subscribe(energys, "energy", handleEnergyEvent)
	subscribe(accelerationSensor, "acceleration ", eventHandler)
*/

	subscribe(alarm, "alarm", eventHandler)
	subscribe(battery, "battery", eventHandler)
	subscribe(beacon, "presence", eventHandler)
	subscribe(button, "button", eventHandler)
	subscribe(carbonMonoxideDetector, "carbonMonoxide", eventHandler)
	subscribe(colorControl, "hue", eventHandler)
    subscribe(colorControl, "saturation", eventHandler)

	subscribe(contactSensor, "contact", eventHandler)
	subscribe(doorControl, "door", eventHandler)
	subscribe(energyMeter, "energy", eventHandler)
	subscribe(illuminanceMeasurement, "illuminance", eventHandler)
	subscribe(imageCapture, "image", eventHandler)
	subscribe(indicator, "indicatorStatus", eventHandler)
	subscribe(locationMode, "mode", eventHandler)
	subscribe(lock, "lock", eventHandler)

	subscribe(mediaController, "activities", eventHandler)
   	subscribe(mediaController, "currentActivity", eventHandler)

	subscribe(motionSensor, "motion", eventHandler)
	subscribe(musicPlayer, "status", eventHandler)
	subscribe(musicPlayer, "level", eventHandler)
	subscribe(musicPlayer, "trackDescription", eventHandler)
	subscribe(musicPlayer, "trackData", eventHandler)
	subscribe(musicPlayer, "mute", eventHandler)

	subscribe(powerMeter, "power", eventHandler)
	subscribe(presenceSensor, "presence", eventHandler)

	subscribe(relativeHumidityMeasurement, "humidity", eventHandler)
	subscribe(relaySwitch, "switch", eventHandler)
	subscribe(sensor, "sensor", eventHandler)
	subscribe(signalStrength, "lqi", eventHandler)
	subscribe(signalStrength, "rssi", eventHandler)
	subscribe(sleepSensor, "sleeping", eventHandler)
	subscribe(smokeDetector, "smoke", eventHandler)
	subscribe(speechRecognition, "phraseSpoken", eventHandler)

	subscribe(stepSensor, "goals", eventHandler)
	subscribe(stepSensor, "steps", eventHandler)
	subscribe(switchv, "switch", eventHandler)
	subscribe(switchLevel, "level", eventHandler)
	subscribe(temperatureMeasurement, "temperature", eventHandler)

	subscribe(thermostat, "temperature", eventHandler)
	subscribe(thermostat, "heatingSetpoint", eventHandler)
	subscribe(thermostat, "coolingSetpoint", eventHandler)
	subscribe(thermostat, "thermostatSetpoint", eventHandler)
	subscribe(thermostat, "thermostatMode", eventHandler)
	subscribe(thermostat, "thermostatFanMode", eventHandler)
	subscribe(thermostat, "thermostatOperatingState", eventHandler)
    
	subscribe(thermostatCoolingSetpoint, "coolingSetpoint", eventHandler)
	subscribe(threeAxis, "threeAxis", eventHandler)

	subscribe(touchSensor, "touch", eventHandler)
	subscribe(valve, "contact", eventHandler)
	subscribe(waterSensor, "water", eventHandler)    
    
    subscribe(app, appTouch)
//    schedule("0/1 * * * * ?", processQueue)
    log.debug "Initialization.. done"
//    processQueue()
}

def eventHandler(evt) {
    queueValue(evt) { it.toString() }
}

def handlePowerEvent(evt) {
    queueValue(evt) { it.toString() }
}

def handleEnergyEvent(evt) {
    queueValue(evt) { it.toString() }
}

def handleTemperatureEvent(evt) {
    queueValue(evt) { it.toString() }
}

def handleHumidityEvent(evt) {
    queueValue(evt) { it.toString() }
}

def handleBatteryEvent(evt) {
    queueValue(evt) { it.toString() }
}

def handleContactEvent(evt) {
    queueValue(evt) { it == "open" ? "true" : "false" }
}

def handleAccelerationEvent(evt) {
    queueValue(evt) { it == "active" ? "true" : "false" }
}

def handleMotionEvent(evt) {
    queueValue(evt) { it == "active" ? "true" : "false" }
}

def handlePresenceEvent(evt) {
    queueValue(evt) { it == "present" ? "true" : "false" }
}

def handleSwitchEvent(evt) {
    queueValue(evt) { it == "on" ? "true" : "false" }
}

/*

private queueValuezzz(evt, Closure convert) {
    def compId = URLEncoder.encode(evt.displayName.trim())
    def streamId = evt.name
    def value = convert(evt.value)

    log.debug "Logging to queue ${compId}, ${streamId} = ${value}"

    def url = "https://grovestreams.com/api/feed?api_key=${channelKey}&compId=${compId}&${streamId}=${value}&time=${now()}"

    def putParams = [
        uri: url,
        body: []
    ]

    state.queue << putParams
}

def processQueue() {
    def url = "https://grovestreams.com/api/feed?api_key=${channelKey}"
    def header = ["X-Forwarded-For": location.id]
    if (state.queue != []) {
        log.debug "Events: ${state.queue}"
        try {
            httpPutJson(["uri": url, "header": header, "body": state.queue]) { 
                response -> 
                if (response.status != 200 ) {
                    log.debug "GroveStreams logging failed, status = ${response.status}"
                } else {
                    log.debug "GroveStreams accepted event(s)"
                    state.queue = []
                }
            }
        } catch(e) {
            def errorInfo = "Error sending value: ${e}"
            log.error errorInfo
        }
    }
}
*/


private queueValue(evt, Closure convert) {
    def compId = URLEncoder.encode(evt.displayName.trim())
    def streamId = evt.name
    def value = convert(evt.value)
    def datetime = getTS()
    def nowTime = new Date().time.toString()
    def ilosc = 0
   
   for(status in state.queue) {
     ilosc++;
   }
   
   if(ilosc>=20) {
     state.queue = []
   }
   
   log.debug("TUTAJ JEST ROZMIARARRRR!!!" + ilosc)

   request = evt.descriptionText
  
   if(request.contains("detected")) {
   
     def porthex = convertPortToHex("1500")
     def hosthex = convertIPtoHex("10.0.0.16")
     def networkid = "$hosthex:$porthex"
     try {
       log.debug "probuje wyslac..."
       sendHubCommand(new physicalgraph.device.HubAction(request, physicalgraph.device.Protocol.LAN, "${networkid}"))
     } catch(e) {
       def errorInfo = "Error sending value: ${e}"
       log.error errorInfo
     }
  }
}

def successClosure = { response ->
  log.debug "Request was successful, $response"
}

def processQueue() {
   log.debug("TUTAJ JEST ROZMIARARRRR!!!" + state.queue.length)
//   def url = "http://ec.greko.eu/dane/index.php?compId=${compId}&${streamId}=${value}"
   def url = "http://ef.greko.eu/charts/dane/index.php?compId=${compId}&${streamId}=${value}"
   log.debug url
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
}

def processQueueLocal() {
   def url = "http://10.0.0.1:85/charts/dane/index.php?compId=${compId}&${streamId}=${value}"
   log.debug url
    if (state.queue != []) {
        log.debug "Events: ${state.queue}"

        try {
            httpPutJson([uri: url, body: state.queue ]) { 
                response -> 
                if (response.status != 200 ) {
                    log.debug "Logging failed, status = ${response.status}"
                } else {
                    log.debug "Accepted event(s)"
                }
            }
        } catch(e) {
            def errorInfo = "Error sending value: ${e}"
            log.error errorInfo
        }
    }    
}


def getTS() {
    def tf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    tf.setTimeZone(location.timeZone)
    return "${tf.format(new Date())}"
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

private trace(message) {
  log.debug message
}

def appTouch(evt) {
	log.debug "appTouch: $evt"
}

def foo(params) {
  log.debug "foo($params)"
}