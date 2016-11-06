package com.sys1yagi.counterpoint.exception

import java.lang.Exception

class InvalidPitchNameException(pitchName: String) : Exception(pitchName)