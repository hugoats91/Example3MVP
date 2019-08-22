package com.practica.mvp.data.exception


class NetworkConnectionException(errorMessage: String = "The connection has failed"):
        Exception(errorMessage)