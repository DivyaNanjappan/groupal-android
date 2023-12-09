/*
 * Copyright 2023. All rights reserved.
 * Dissemination of this information or reproduction of this material is strictly forbidden
 * unless prior written permission is obtained from Divya N.
 *
 * Created by Divya N
 */

package com.groupal.design.utils

import androidx.annotation.IntDef
import com.groupal.design.utils.IntentType.Companion.CLEAR_TASK
import com.groupal.design.utils.IntentType.Companion.DEFAULT
import com.groupal.design.utils.IntentType.Companion.SINGLE_TOP

@IntDef(SINGLE_TOP,
        CLEAR_TASK,
        DEFAULT)
annotation class IntentType {
    companion object {
        const val SINGLE_TOP = 0
        const val CLEAR_TASK = 1
        const val DEFAULT = 2
    }
}

