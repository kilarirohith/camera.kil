package com.nuncsystems.cameraapp.usecase

import android.content.ContentResolver
import android.os.Build
import androidx.annotation.RequiresApi
import com.nuncsystems.cameraapp.model.RecordedVideo
import com.nuncsystems.cameraapp.videolist.OsPAndAboveRecordedVideoLoader
import javax.inject.Inject

/**
 * [SuspendUseCase] implementation which loads the recorded files store onto the device download folder for OS Q and above.
 *
 */
@RequiresApi(Build.VERSION_CODES.Q)
class OsPAndAboveRecordedVideoLoadUseCaseImpl @Inject constructor() : OsPAndAboveRecordedVideoLoadUseCase {
    override suspend fun invoke(input: ContentResolver): List<RecordedVideo> {
        val osPAndAboveRecordedVideoLoader = OsPAndAboveRecordedVideoLoader(input)
        return osPAndAboveRecordedVideoLoader.loadData()
    }
}