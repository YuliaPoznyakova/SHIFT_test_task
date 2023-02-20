package com.nrp.shift_test_task.dto

class CardDto (
    val number: NumberDto,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val country: CountryDto,
    val bank: BankDto
    )