package com.wljr.kotlinsutdydemo.summary.model

data class MemberListEntity(
    val code: Int,
    val message: String,
    val source_data: SourceData
){
    data class SourceData(
        val page: Int,
        val source_list: List<Source>,
        val totalPage: Int
    ){
        data class Source(
            val activity_name: String,
            val activity_rate: Int,
            val name: String,
            val novice_exclusive: String,
            val ordered_amount: Int,
            val ordered_percent: String,
            val pay_method: String,
            val period: String,
            val period_day: String,
            val project_id: String,
            val rate_end: Int,
            val remain_amount: Int,
            val scatter_type: String,
            val short_name: String,
            val target_state: String,
            val total_amount: Int,
            val type: Int
        )
    }

}


