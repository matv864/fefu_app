package com.example.fefu_app.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activityTypes")
data class ActivityTypeEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String
)