package uz.project.mycarwashproject.model.remote


class ProposalModel(
    val carName: String = "",
    val carNumber: String = "",
    var price: String = "",
    var time: String = "",
    var isFinished: Boolean = false,
    var typeoforder: String = "VIP",
    var point: Int = 0
)


