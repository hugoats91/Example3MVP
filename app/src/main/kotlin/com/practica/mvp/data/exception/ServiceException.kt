package com.practica.mvp.data.exception


class ServiceException(errorMessage: String = "An error has occurred with the server"):
        Exception(errorMessage)