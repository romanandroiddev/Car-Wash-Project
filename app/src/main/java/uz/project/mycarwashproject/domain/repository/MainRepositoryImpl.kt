package uz.project.mycarwashproject.domain.repository

import com.google.firebase.firestore.*
import timber.log.Timber
import uz.project.mycarwashproject.model.local.SharePref
import uz.project.mycarwashproject.model.remote.ProposalModel
import uz.project.mycarwashproject.presenter.addvehiclenum.VehicleNumClass
import uz.project.mycarwashproject.presenter.main.pages.history.Car

class MainRepositoryImpl(
    private val pref: SharePref,
    private var db: FirebaseFirestore
) : MainRepository {

    override fun isSignUp(): Boolean = pref.getIsSignUp
    override fun getPhone(): String = pref.profileId

    override fun saveProfileNum(phone: String) {
        pref.profileId = phone
    }

    override fun saveSignUpState(state: Boolean) {
        pref.getIsSignUp = state
    }

    override fun submitProposal(proposalModel: ProposalModel): String {
        var response = "Jazildi !"
        val map = HashMap<String, Any>()
        map["carName"] = proposalModel.carName;
        map["carNumber"] = proposalModel.carNumber;
        map["price"] = proposalModel.price;
        map["time"] = proposalModel.time;
        map["isfinished"] = proposalModel.isFinished;
        map["typeoforder"] = proposalModel.typeoforder;
        map["point"] = 0;

        db.collection(getPhone()).document("queue").collection("cars").document().set(map)
            .addOnSuccessListener {
                response = "Success"
            }.addOnFailureListener {

                response = "Fail"
            }
        return response
    }

    override fun submitProposalNum(proposalModel: VehicleNumClass): String {
        var response = "Jazildi !"
        val map = HashMap<String, Any>()
        map["modelName"] = proposalModel.modelName;
        map["modelNumber"] = proposalModel.modelNumber;
        map["img"] = 0;

        db.collection(getPhone()).document("CarInfo").collection("cars").document().set(map)
            .addOnSuccessListener {
                response = "Success"
            }.addOnFailureListener {

                response = "Fail"
            }
        return response
    }


    companion object {
        val yourcarlist = mutableSetOf<VehicleNumClass>()
        val historycarlist = mutableListOf<Car>()
    }


    override fun getYourCars(): MutableSet<VehicleNumClass> {
        db = FirebaseFirestore.getInstance()

        db.collection(getPhone()).document("CarInfo").collection("cars")
            .addSnapshotListener(object : EventListener<QuerySnapshot> {

                override fun onEvent(
                    value: QuerySnapshot?, error: FirebaseFirestoreException?
                ) {

                    if (error != null) {
                        Timber.v("Fail eventchangeListener")
                        return
                    }
                    for (dc: DocumentChange in value?.documentChanges!!) {
                        if (dc.type == DocumentChange.Type.ADDED) {

                            yourcarlist.add(dc.document.toObject(VehicleNumClass::class.java))
                        }
                    }
                }

            })
        Timber.tag("TTTT").v("Успешно прошел c FireStore!")
        return yourcarlist
    }

    override fun historyPageCars(): List<Car> {
        db = FirebaseFirestore.getInstance()

        db.collection(getPhone())
            .addSnapshotListener(object : EventListener<QuerySnapshot> {

                override fun onEvent(
                    value: QuerySnapshot?, error: FirebaseFirestoreException?
                ) {

                    if (error != null) {
                        Timber.v("Fail eventchangeListener")
                        return
                    }
                    for (dc: DocumentChange in value?.documentChanges!!) {
                        if (dc.type == DocumentChange.Type.ADDED) {

                            historycarlist.add(dc.document.toObject(Car::class.java))
                        }
                    }
                }

            })
        Timber.tag("TTTT").v("Успешно historycars!")
        return historycarlist
    }
}