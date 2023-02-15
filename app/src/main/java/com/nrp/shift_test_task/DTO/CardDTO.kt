package com.nrp.shift_test_task.DTO

import com.squareup.moshi.Json

class CardDTO (
    val number: NumberDTO,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val country: CountryDTO,
    val bank: BankDTO
    )