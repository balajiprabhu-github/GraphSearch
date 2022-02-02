package com.balajiprabhu.graphsearch.model

import com.google.gson.annotations.SerializedName


data class Properties (

  @SerializedName("name"             ) var name           : String? = null,
  @SerializedName("permalink"        ) var permalink      : String? = null,
  @SerializedName("picture"        ) var picture      : String? = null,
  @SerializedName("founded_at"       ) var foundedAt      : String? = null,
  @SerializedName("first_funding_at" ) var firstFundingAt : String? = null,
  @SerializedName("market"           ) var market         : String? = null,
  @SerializedName("founded_quarter"  ) var foundedQuarter : String? = null,
  @SerializedName("founded_year"     ) var foundedYear    : Int?    = null,
  @SerializedName("state"            ) var state          : String? = null,
  @SerializedName("url"              ) var url            : String? = null,
  @SerializedName("country"          ) var country        : String? = null,
  @SerializedName("homepage_url"     ) var homepageUrl    : String? = null,
  @SerializedName("logo"             ) var logo           : String? = null,
  @SerializedName("founded_month"    ) var foundedMonth   : String? = null,
  @SerializedName("funding_rounds"   ) var fundingRounds  : Int?    = null,
  @SerializedName("status"           ) var status         : String? = null,
  @SerializedName("funding_total"    ) var fundingTotal   : Int?    = null,
  @SerializedName("region"           ) var region         : String? = null,
  @SerializedName("category"         ) var category       : String? = null,
  @SerializedName("last_funding_at"  ) var lastFundingAt  : String? = null,
  @SerializedName("funded_month"       ) var fundedMonth      : String? = null,
  @SerializedName("funded_quarter"     ) var fundedQuarter    : String? = null,
  @SerializedName("funded_year"        ) var fundedYear       : Int?    = null,
  @SerializedName("funded_at"          ) var fundedAt         : String? = null,
  @SerializedName("funding_round_type" ) var fundingRoundType : String? = null,
  @SerializedName("funding_round_code" ) var fundingRoundCode : String? = null,
  @SerializedName("raised_amount_usd"  ) var raisedAmountUsd  : Int?    = null

)