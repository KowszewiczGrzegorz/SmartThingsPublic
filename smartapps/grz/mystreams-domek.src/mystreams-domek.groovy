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
    name: "MyStreams_Domek",
    namespace: "Grz",
    author: "Grz",
    description: "Log to mystreams",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png")

preferences {
/*	section("Force state update..") {
        buttons(name: "buttons", title: "required:false, multiple:false", required: false, multiple: false, buttons: [
			[label: "foo", action: "foo"],
			[label: "bar", action: "foo"]
		])
  */      
//		input "wlaczniki", "capability.switch", multiple: true
//	}

    section("Log devices...") {
		input "accelerationSensor", "capability.accelerationSensor", title: "Acceleration Sensor", required: false, multiple: true
		input "actuator", "capability.actuator", title: "Actuator", required: false, multiple: true
		input "alarm", "capability.alarm", title: "Alarm", required: false, multiple: true
		input "battery", "capability.battery", title: "Battery", required: false, multiple: true
		input "beacon", "capability.beacon", title: "Beacon", required: false, multiple: true
		input "button", "capability.button", title: "Button", required: false, multiple: true
		input "carbonMonoxideDetector", "capability.carbonMonoxideDetector", title: "Carbon Monoxide Detector", required: false, multiple: true
		input "colorControl", "capability.colorControl", title: "Color Control", required: false, multiple: true
		input "colorTemperature", "capability.colorTemperature", title: "Color Temperature", required: false, multiple: true
		input "configuration", "capability.configuration", title: "Configuration", required: false, multiple: true
		input "consumable", "capability.consumable", title: "Consumable", required: false, multiple: true
		input "contactSensor", "capability.contactSensor", title: "Contact Sensor", required: false, multiple: true
		input "doorControl", "capability.doorControl", title: "Door Control", required: false, multiple: true
		input "energyMeter", "capability.energyMeter", title: "Energy Meter", required: false, multiple: true
		input "garageDoorControl", "capability.garageDoorControl", title: "Garage Door Control", required: false, multiple: true
		input "illuminanceMeasurement", "capability.illuminanceMeasurement", title: "Illuminance Measurement", required: false, multiple: true
		input "imageCapture", "capability.imageCapture", title: "Image Capture", required: false, multiple: true
		input "indicator", "capability.indicator", title: "Indicator", required: false, multiple: true           //depre?
		input "locationMode", "capability.locationMode", title: "Location Mode", required: false, multiple: true //depre
		input "lock", "capability.lock", title: "Lock", required: false, multiple: true                          //depre
		input "lockCodes", "capability.lockCodes", title: "Lock Codes", required: false, multiple: true
		input "mediaController", "capability.mediaController", title: "Media Controller", required: false, multiple: true
		input "momentary", "capability.momentary", title: "Momentary", required: false, multiple: true
		input "motionSensor", "capability.motionSensor", title: "Motion Sensor", required: false, multiple: true
		input "musicPlayer", "capability.musicPlayer", title: "Music Player", required: false, multiple: true
		input "notification", "capability.notification", title: "Notification", required: false, multiple: true
		input "polling", "capability.polling", title: "Polling", required: false, multiple: true
		input "powerMeter", "capability.powerMeter", title: "Power Meter", required: false, multiple: true
		input "presenceSensor", "capability.presenceSensor", title: "Presence Sensor", required: false, multiple: true
		input "refresh", "capability.refresh", title: "Refresh", required: false, multiple: true
		input "relativeHumidityMeasurement", "capability.relativeHumidityMeasurement", title: "Relative Humidity Measurement", required: false, multiple: true
		input "relaySwitch", "capability.relaySwitch", title: "Relay Switch", required: false, multiple: true
		input "sensor", "capability.sensor", title: "Sensor", required: false, multiple: true
		input "signalStrength", "capability.signalStrength", title: "Signal Strength", required: false, multiple: true
		input "sleepSensor", "capability.sleepSensor", title: "Sleep Sensor", required: false, multiple: true
		input "smokeDetector", "capability.smokeDetector", title: "Smoke Detector", required: false, multiple: true
		input "soundSensor", "capability.soundSensor", title: "Sound Sensor", required: false, multiple: true
		input "speechRecognition", "capability.speechRecognition", title: "Speech Recognition", required: false, multiple: true
		input "speechSynthesis", "capability.speechSynthesis", title: "Speech Synthesis", required: false, multiple: true
		input "stepSensor", "capability.stepSensor", title: "Step Sensor", required: false, multiple: true
		input "switchv", "capability.switch", title: "Switch", required: false, multiple: true
		input "switchLevel", "capability.switchLevel", title: "Switch Level", required: false, multiple: true
		input "temperatureMeasurement", "capability.temperatureMeasurement", title: "Temperature Measurement", required: false, multiple: true
		input "testCapability", "capability.testCapability", title: "Test Capability", required: false, multiple: true // depre?
		input "thermostat", "capability.thermostat", title: "Thermostat", required: false, multiple: true
		input "thermostatCoolingSetpoint", "capability.thermostatCoolingSetpoint", title: "Thermostat Cooling Setpoint", required: false, multiple: true
		input "thermostatFanMode", "capability.thermostatFanMode", title: "Thermostat Fan Mode", required: false, multiple: true
		input "thermostatHeatingSetpoint", "capability.thermostatHeatingSetpoint", title: "Thermostat Heating Setpoint", required: false, multiple: true
		input "thermostatMode", "capability.thermostatMode", title: "Thermostat Mode", required: false, multiple: true
		input "thermostatOperatingState", "capability.thermostatOperatingState", title: "Thermostat Operating State", required: false, multiple: true
		input "thermostatSetpoint", "capability.thermostatSetpoint", title: "Thermostat Setpoint", required: false, multiple: true
		input "threeAxis", "capability.threeAxis", title: "Three Axis", required: false, multiple: true
		input "tone", "capability.tone", title: "Tone", required: false, multiple: true
		input "touchSensor", "capability.touchSensor", title: "TouchSensor", required: false, multiple: true
		input "valve", "capability.valve", title: "Valve", required: false, multiple: true
		input "waterSensor", "capability.waterSensor", title: "Water Sensor", required: false, multiple: true
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
// skopiowalem gorne capabilities i uruchomilem: cat ok.txt | awk '{print "    subscribe(contactSensor, "$2" eventHandler)"}'  | less

    subscribe(contactSensor, "accelerationSensor", eventHandler)
    subscribe(contactSensor, "actuator", eventHandler)
    subscribe(contactSensor, "alarm", eventHandler)
    subscribe(contactSensor, "battery", eventHandler)
    subscribe(contactSensor, "beacon", eventHandler)
    subscribe(contactSensor, "button", eventHandler)
    subscribe(contactSensor, "carbonMonoxideDetector", eventHandler)
    subscribe(contactSensor, "colorControl", eventHandler)
    subscribe(contactSensor, "colorTemperature", eventHandler)
    subscribe(contactSensor, "configuration", eventHandler)
    subscribe(contactSensor, "consumable", eventHandler)
    subscribe(contactSensor, "contactSensor", eventHandler)
    subscribe(contactSensor, "doorControl", eventHandler)
    subscribe(contactSensor, "energyMeter", eventHandler)
    subscribe(contactSensor, "garageDoorControl", eventHandler)
    subscribe(contactSensor, "illuminanceMeasurement", eventHandler)
    subscribe(contactSensor, "imageCapture", eventHandler)
    subscribe(contactSensor, "indicator", eventHandler)
    subscribe(contactSensor, "locationMode", eventHandler)
    subscribe(contactSensor, "lock", eventHandler)
    subscribe(contactSensor, "lockCodes", eventHandler)
    subscribe(contactSensor, "mediaController", eventHandler)
    subscribe(contactSensor, "momentary", eventHandler)
    subscribe(contactSensor, "motionSensor", eventHandler)
    subscribe(contactSensor, "musicPlayer", eventHandler)
    subscribe(contactSensor, "notification", eventHandler)
    subscribe(contactSensor, "polling", eventHandler)
    subscribe(contactSensor, "powerMeter", eventHandler)
    subscribe(contactSensor, "presenceSensor", eventHandler)
    subscribe(contactSensor, "refresh", eventHandler)
    subscribe(contactSensor, "relativeHumidityMeasurement", eventHandler)
    subscribe(contactSensor, "relaySwitch", eventHandler)
    subscribe(contactSensor, "sensor", eventHandler)
    subscribe(contactSensor, "signalStrength", eventHandler)
    subscribe(contactSensor, "sleepSensor", eventHandler)
    subscribe(contactSensor, "smokeDetector", eventHandler)
    subscribe(contactSensor, "soundSensor", eventHandler)
    subscribe(contactSensor, "speechRecognition", eventHandler)
    subscribe(contactSensor, "speechSynthesis", eventHandler)
    subscribe(contactSensor, "stepSensor", eventHandler)
    subscribe(contactSensor, "switchv", eventHandler)
    subscribe(contactSensor, "switchLevel", eventHandler)
    subscribe(contactSensor, "temperatureMeasurement", eventHandler)
    subscribe(contactSensor, "testCapability", eventHandler)
    subscribe(contactSensor, "thermostat", eventHandler)
    subscribe(contactSensor, "thermostatCoolingSetpoint", eventHandler)
    subscribe(contactSensor, "thermostatFanMode", eventHandler)
    subscribe(contactSensor, "thermostatHeatingSetpoint", eventHandler)
    subscribe(contactSensor, "thermostatMode", eventHandler)
    subscribe(contactSensor, "thermostatOperatingState", eventHandler)
    subscribe(contactSensor, "thermostatSetpoint", eventHandler)
    subscribe(contactSensor, "threeAxis", eventHandler)
    subscribe(contactSensor, "tone", eventHandler)
    subscribe(contactSensor, "touchSensor", eventHandler)
    subscribe(contactSensor, "valve", eventHandler)
    subscribe(contactSensor, "waterSensor", eventHandler)

    subscribe(app, appTouch)
    schedule("0/1 * * * * ?", processQueue)
    log.debug "Initialization.. done"
    processQueue()
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

private queueValue(evt, Closure convert) {
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
   
//   log.debug("TUTAJ JEST ROZMIARARRRR!!!" + ilosc)

   	def json_body = [
            device_id: evt.deviceId,
            date: evt.isoDate,
            timestamp: nowTime,
            datetime: datetime.toString(),
        	value: evt.value,
            name: evt.name,
            display_name: evt.displayName, 
            description: evt.descriptionText,
            source: evt.source, 
            state_changed: evt.isStateChange(),
            physical: evt.isPhysical(),
            location_id: evt.locationId,
            hub_id: evt.hubId, 
            smartapp_id: evt.installedSmartAppId        
      ] 


   state.queue << json_body

//   log.debug(state.queue)
   request = evt.descriptionText
//   processQueueLocal()
   processQueue()
//   processQueue()
/*
   def porthex = convertPortToHex("5555")
   def hosthex = convertIPtoHex("10.0.0.14")
   def networkid = "$hosthex:$porthex"
   try {
     log.debug "probuje wyslac..."
     sendHubCommand(new physicalgraph.device.HubAction(request, physicalgraph.device.Protocol.LAN, "${networkid}"))
   } catch(e) {
     def errorInfo = "Error sending value: ${e}"
     log.error errorInfo
   }
*/
}

def successClosure = { response ->
  log.debug "Request was successful, $response"
}

def processQueue() {
//   log.debug("TUTAJ JEST ROZMIARARRRR!!!" + state.queue.length)
   def url = "https://d.greko.eu/charts/dane/index.php?compId=${compId}&${streamId}=${value}"
//   def url = "http://ec.greko.eu/dane/index.php?compId=${compId}&${streamId}=${value}"
//   def url = "http://ef.greko.eu/charts/dane/index.php?compId=${compId}&${streamId}=${value}"
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