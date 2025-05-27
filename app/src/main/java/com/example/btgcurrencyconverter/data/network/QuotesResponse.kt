package com.example.btgcurrencyconverter.data.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrencyExchangeResponse(
    @SerialName("success")
    val success: Boolean,

    @SerialName("source")
    val source: String,

    @SerialName("quotes")
    val quotes: CurrencyQuotes
)

@Serializable
data class CurrencyQuotes(
    @SerialName("USDAED")
    val usdAed: Double,

    @SerialName("USDAFN")
    val usdAfn: Double,

    @SerialName("USDALL")
    val usdAll: Double,

    @SerialName("USDAMD")
    val usdAmd: Double,

    @SerialName("USDANG")
    val usdAng: Double,

    @SerialName("USDAOA")
    val usdAoa: Double,

    @SerialName("USDARS")
    val usdArs: Double,

    @SerialName("USDAUD")
    val usdAud: Double,

    @SerialName("USDAWG")
    val usdAwg: Double,

    @SerialName("USDAZN")
    val usdAzn: Double,

    @SerialName("USDBAM")
    val usdBam: Double,

    @SerialName("USDBBD")
    val usdBbd: Double,

    @SerialName("USDBDT")
    val usdBdt: Double,

    @SerialName("USDBGN")
    val usdBgn: Double,

    @SerialName("USDBHD")
    val usdBhd: Double,

    @SerialName("USDBIF")
    val usdBif: Double,

    @SerialName("USDBMD")
    val usdBmd: Double,

    @SerialName("USDBND")
    val usdBnd: Double,

    @SerialName("USDBOB")
    val usdBob: Double,

    @SerialName("USDBRL")
    val usdBrl: Double,

    @SerialName("USDBSD")
    val usdBsd: Double,

    @SerialName("USDBTC")
    val usdBtc: Double,

    @SerialName("USDBTN")
    val usdBtn: Double,

    @SerialName("USDBWP")
    val usdBwp: Double,

    @SerialName("USDBYN")
    val usdByn: Double,

    @SerialName("USDBYR")
    val usdByr: Double,

    @SerialName("USDBZD")
    val usdBzd: Double,

    @SerialName("USDCAD")
    val usdCad: Double,

    @SerialName("USDCDF")
    val usdCdf: Double,

    @SerialName("USDCHF")
    val usdChf: Double,

    @SerialName("USDCLF")
    val usdClf: Double,

    @SerialName("USDCLP")
    val usdClp: Double,

    @SerialName("USDCNY")
    val usdCny: Double,

    @SerialName("USDCOP")
    val usdCop: Double,

    @SerialName("USDCRC")
    val usdCrc: Double,

    @SerialName("USDCUC")
    val usdCuc: Double,

    @SerialName("USDCUP")
    val usdCup: Double,

    @SerialName("USDCVE")
    val usdCve: Double,

    @SerialName("USDCZK")
    val usdCzk: Double,

    @SerialName("USDDJF")
    val usdDjf: Double,

    @SerialName("USDDKK")
    val usdDkk: Double,

    @SerialName("USDDOP")
    val usdDop: Double,

    @SerialName("USDDZD")
    val usdDzd: Double,

    @SerialName("USDEGP")
    val usdEgp: Double,

    @SerialName("USDERN")
    val usdErn: Double,

    @SerialName("USDETB")
    val usdEtb: Double,

    @SerialName("USDEUR")
    val usdEur: Double,

    @SerialName("USDFJD")
    val usdFjd: Double,

    @SerialName("USDFKP")
    val usdFkp: Double,

    @SerialName("USDGBP")
    val usdGbp: Double,

    @SerialName("USDGEL")
    val usdGel: Double,

    @SerialName("USDGGP")
    val usdGgp: Double,

    @SerialName("USDGHS")
    val usdGhs: Double,

    @SerialName("USDGIP")
    val usdGip: Double,

    @SerialName("USDGMD")
    val usdGmd: Double,

    @SerialName("USDGNF")
    val usdGnf: Double,

    @SerialName("USDGTQ")
    val usdGtq: Double,

    @SerialName("USDGYD")
    val usdGyd: Double,

    @SerialName("USDHKD")
    val usdHkd: Double,

    @SerialName("USDHNL")
    val usdHnl: Double,

    @SerialName("USDHRK")
    val usdHrk: Double,

    @SerialName("USDHTG")
    val usdHtg: Double,

    @SerialName("USDHUF")
    val usdHuf: Double,

    @SerialName("USDIDR")
    val usdIdr: Double,

    @SerialName("USDILS")
    val usdIls: Double,

    @SerialName("USDIMP")
    val usdImp: Double,

    @SerialName("USDINR")
    val usdInr: Double,

    @SerialName("USDIQD")
    val usdIqd: Double,

    @SerialName("USDIRR")
    val usdIrr: Double,

    @SerialName("USDISK")
    val usdIsk: Double,

    @SerialName("USDJEP")
    val usdJep: Double,

    @SerialName("USDJMD")
    val usdJmd: Double,

    @SerialName("USDJOD")
    val usdJod: Double,

    @SerialName("USDJPY")
    val usdJpy: Double,

    @SerialName("USDKES")
    val usdKes: Double,

    @SerialName("USDKGS")
    val usdKgs: Double,

    @SerialName("USDKHR")
    val usdKhr: Double,

    @SerialName("USDKMF")
    val usdKmf: Double,

    @SerialName("USDKPW")
    val usdKpw: Double,

    @SerialName("USDKRW")
    val usdKrw: Double,

    @SerialName("USDKWD")
    val usdKwd: Double,

    @SerialName("USDKYD")
    val usdKyd: Double,

    @SerialName("USDKZT")
    val usdKzt: Double,

    @SerialName("USDLAK")
    val usdLak: Double,

    @SerialName("USDLBP")
    val usdLbp: Double,

    @SerialName("USDLKR")
    val usdLkr: Double,

    @SerialName("USDLRD")
    val usdLrd: Double,

    @SerialName("USDLSL")
    val usdLsl: Double,

    @SerialName("USDLTL")
    val usdLtl: Double,

    @SerialName("USDLVL")
    val usdLvl: Double,

    @SerialName("USDLYD")
    val usdLyd: Double,

    @SerialName("USDMAD")
    val usdMad: Double,

    @SerialName("USDMDL")
    val usdMdl: Double,

    @SerialName("USDMGA")
    val usdMga: Double,

    @SerialName("USDMKD")
    val usdMkd: Double,

    @SerialName("USDMMK")
    val usdMmk: Double,

    @SerialName("USDMNT")
    val usdMnt: Double,

    @SerialName("USDMOP")
    val usdMop: Double,

    @SerialName("USDMRO")
    val usdMro: Double,

    @SerialName("USDMUR")
    val usdMur: Double,

    @SerialName("USDMVR")
    val usdMvr: Double,

    @SerialName("USDMWK")
    val usdMwk: Double,

    @SerialName("USDMXN")
    val usdMxn: Double,

    @SerialName("USDMYR")
    val usdMyr: Double,

    @SerialName("USDMZN")
    val usdMzn: Double,

    @SerialName("USDNAD")
    val usdNad: Double,

    @SerialName("USDNGN")
    val usdNgn: Double,

    @SerialName("USDNIO")
    val usdNio: Double,

    @SerialName("USDNOK")
    val usdNok: Double,

    @SerialName("USDNPR")
    val usdNpr: Double,

    @SerialName("USDNZD")
    val usdNzd: Double,

    @SerialName("USDOMR")
    val usdOmr: Double,

    @SerialName("USDPAB")
    val usdPab: Double,

    @SerialName("USDPEN")
    val usdPen: Double,

    @SerialName("USDPGK")
    val usdPgk: Double,

    @SerialName("USDPHP")
    val usdPhp: Double,

    @SerialName("USDPKR")
    val usdPkr: Double,

    @SerialName("USDPLN")
    val usdPln: Double,

    @SerialName("USDPYG")
    val usdPyg: Double,

    @SerialName("USDQAR")
    val usdQar: Double,

    @SerialName("USDRON")
    val usdRon: Double,

    @SerialName("USDRSD")
    val usdRsd: Double,

    @SerialName("USDRUB")
    val usdRub: Double,

    @SerialName("USDRWF")
    val usdRwf: Double,

    @SerialName("USDSAR")
    val usdSar: Double,

    @SerialName("USDSBD")
    val usdSbd: Double,

    @SerialName("USDSCR")
    val usdScr: Double,

    @SerialName("USDSDG")
    val usdSdg: Double,

    @SerialName("USDSEK")
    val usdSek: Double,

    @SerialName("USDSGD")
    val usdSgd: Double,

    @SerialName("USDSHP")
    val usdShp: Double,

    @SerialName("USDSLL")
    val usdSll: Double,

    @SerialName("USDSOS")
    val usdSos: Double,

    @SerialName("USDSRD")
    val usdSrd: Double,

    @SerialName("USDSTD")
    val usdStd: Double,

    @SerialName("USDSVC")
    val usdSvc: Double,

    @SerialName("USDSYP")
    val usdSyp: Double,

    @SerialName("USDSZL")
    val usdSzl: Double,

    @SerialName("USDTHB")
    val usdThb: Double,

    @SerialName("USDTJS")
    val usdTjs: Double,

    @SerialName("USDTMT")
    val usdTmt: Double,

    @SerialName("USDTND")
    val usdTnd: Double,

    @SerialName("USDTOP")
    val usdTop: Double,

    @SerialName("USDTRY")
    val usdTry: Double,

    @SerialName("USDTTD")
    val usdTtd: Double,

    @SerialName("USDTWD")
    val usdTwd: Double,

    @SerialName("USDTZS")
    val usdTzs: Double,

    @SerialName("USDUAH")
    val usdUah: Double,

    @SerialName("USDUGX")
    val usdUgx: Double,

    @SerialName("USDUSD")
    val usdUsd: Double,

    @SerialName("USDUYU")
    val usdUyu: Double,

    @SerialName("USDUZS")
    val usdUzs: Double,

    @SerialName("USDVEF")
    val usdVef: Double,

    @SerialName("USDVND")
    val usdVnd: Double,

    @SerialName("USDVUV")
    val usdVuv: Double,

    @SerialName("USDWST")
    val usdWst: Double,

    @SerialName("USDXAF")
    val usdXaf: Double,

    @SerialName("USDXAG")
    val usdXag: Double,

    @SerialName("USDXAU")
    val usdXau: Double,

    @SerialName("USDXCD")
    val usdXcd: Double,

    @SerialName("USDXDR")
    val usdXdr: Double,

    @SerialName("USDXOF")
    val usdXof: Double,

    @SerialName("USDXPF")
    val usdXpf: Double,

    @SerialName("USDYER")
    val usdYer: Double,

    @SerialName("USDZAR")
    val usdZar: Double,

    @SerialName("USDZMK")
    val usdZmk: Double,

    @SerialName("USDZMW")
    val usdZmw: Double,

    @SerialName("USDZWL")
    val usdZwl: Double
)
