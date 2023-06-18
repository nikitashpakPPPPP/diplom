package com.myapp.catatuang

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    private lateinit var currencyAdapter: CurrencyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Установка RecyclerView для списка валют
        val layoutManager = LinearLayoutManager(this)
        currencyRecyclerView.layoutManager = layoutManager

        // Инициализация адаптера списка валют
        currencyAdapter = CurrencyAdapter(getCurrencyList(), ::onCurrencySelected)
        currencyRecyclerView.adapter = currencyAdapter

        // Обработка события выбора языка
        languageSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedLanguage = parent?.getItemAtPosition(position).toString()
                //  Применить выбранный язык
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Ничего не делать
            }
        }

        // Обработка события выбора темы
        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Применить выбранную тему (светлая/темная)
        }
    }

    private fun getCurrencyList(): List<String> {
        // Получить список активных валют из базы данных или ресурсов приложения
        return listOf("USD", "EUR", "GBP", "JPY") // Пример списка валют
    }

    private fun onCurrencySelected(currency: String) {
        //  Применить выбранную валюту
        Toast.makeText(this, "Выбрана валюта: $currency", Toast.LENGTH_SHORT).show()
    }
}
