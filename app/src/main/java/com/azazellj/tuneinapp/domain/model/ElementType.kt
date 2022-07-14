package com.azazellj.tuneinapp.domain.model


sealed class ElementType {
    object Link : ElementType()
    object Group : ElementType()
    object Audio : ElementType()
}