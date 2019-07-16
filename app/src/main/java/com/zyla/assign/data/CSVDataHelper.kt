package com.zyla.assign.data

import java.io.BufferedReader
import java.io.InputStreamReader


class CSVDataHelper {

    fun readCSVFile(inputStreamReader: InputStreamReader): ArrayList<CSVRow> {
        val rowList = ArrayList<CSVRow>()
        val reader = BufferedReader(inputStreamReader)
        reader.readLine()
        var line: String? = reader.readLine()
        var artist: String
        var album: String
        var song: String
        while (line != null) {
            val rowElements = line.split(",")
            if (!rowElements.isNullOrEmpty() && rowElements.size == 3) {
                song = rowElements[0]
                artist = rowElements[1]
                album = rowElements[2]
                if (artist.isNotEmpty() && album.isNotEmpty() && song.isNotEmpty()) {
                    rowList.add(CSVRow(artist, album, song))
                }
            }
            line = reader.readLine()
        }
        return rowList
    }
}