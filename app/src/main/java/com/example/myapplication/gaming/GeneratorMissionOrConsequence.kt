package com.example.myapplication.gaming

import android.content.Context
import android.content.res.Resources
import com.example.myapplication.R
import com.example.myapplication.utilities.EnumUtil
import com.example.myapplication.utilities.getRandomListIndex

class GeneratorMissionOrConsequence(val context: Context) {

	private val res: Resources = context.resources

	private val listOfConsequences = res.getStringArray(R.array.Consequences)
	private val listOfMissions = res.getStringArray(R.array.Mission)
	private val listOfConsequencesPoints = res.getIntArray(R.array.ConsequencesPoints)
	private val listOfMissionsPoints = res.getIntArray(R.array.MissionPoints)

	fun generateNewCard(): CardMissionConsequence {

		val rIndex: Int
		val cardText: String
		val cardPoints: Double
		val cardType: EnumUtil.EnRandom

		when (val rCardType = EnumUtil.EnRandom.values().random()) {
			EnumUtil.EnRandom.CONSEQUENCES -> {

				rIndex = listOfConsequences.getRandomListIndex()
				cardText = listOfConsequences[rIndex]
				cardPoints = listOfConsequencesPoints[rIndex].toDouble()
				cardType = rCardType
			}
			EnumUtil.EnRandom.MISSION -> {

				rIndex = listOfMissions.getRandomListIndex()
				cardText = listOfMissions[rIndex]
				cardPoints = listOfMissionsPoints[rIndex].toDouble()
				cardType = rCardType

			}
		}
		return CardMissionConsequence(cardText, cardPoints, cardType)
	}
}