package com.myapp.catatuang

class FinancialGoal(
    var title: String,
    var description: String,
    var targetAmount: Double,
    var totalSaved: Double,
    var isCompleted: Boolean = false
) {
    //метод для изменения цели
    fun editGoal(title: String, description: String, targetAmount: Double) {
        this.title = title
        this.description = description
        this.targetAmount = targetAmount
    }

    //метод для обновления прогресса цели
    fun updateProgress(saved: Double) {
        this.totalSaved += saved
        if (this.totalSaved >= this.targetAmount) {
            this.isCompleted = true
        }
    }

    //метод для удаления цели
    fun deleteGoal() {
        this.title = ""
        this.description = ""
        this.targetAmount = 0.0
        this.totalSaved = 0.0
    }
}