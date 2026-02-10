import java.math.BigDecimal

object ChangeCalculatorKt {
private fun coinChangeAlghoritm(difference: Int, insertedCoins: List<Int>, coinSystem: Set<Int>, change: Map<Int, Int>):  Map<Int, Int>{
//    coinSystem.sortedDescending().forEach {
//        it in coinSystem
//    }
    var sortedCoins = coinSystem.sortedDescending()
    var myDifference = difference
    var resultMap = mutableMapOf<Int,Int>()
    for (it in sortedCoins){
        var coinNumber = myDifference/it
        if(coinNumber > 0){
            myDifference %= it
            resultMap[coinNumber] = it
        }
    }
    return resultMap
    }
//    coinSystem.sortedDescending().get()

    fun calculateMinCoinsForChange(productCost: BigDecimal, insertedCoins: List<Int>, coinSystem: Set<Int>): Map<Int, Int> {
        var change: MutableMap<Int, Int> = HashMap()
        var sumInserted = insertedCoins.sum()
        var difference = sumInserted-productCost.multiply(BigDecimal.valueOf(100)).toInt()
        //coinSystem.sortedDescending().fold()
        return coinChangeAlghoritm(difference, insertedCoins, coinSystem, change)
    }
}

fun main() {

}

fun calculateMinCoinsForChange(productCost: BigDecimal, insertedCoins: List<Int>, coinSystem: Set<Int>): Map<Int, Int>
        = coinSystem.sortedDescending()
    .fold(emptyList<Int>() to calculateChangeAmount(insertedCoins, productCost)) { acc, coinNominal ->
        getNumberOfCoinsAndUpdateRemainingChange(acc, coinNominal)
    }
    .first
    .groupingBy { it }
    .eachCount()

private fun calculateChangeAmount(insertedCoins: List<Int>, productCost: BigDecimal) =
    insertedCoins.sum() - productCost.times(BigDecimal(100)).toInt()

private fun getNumberOfCoinsAndUpdateRemainingChange(acc: Pair<List<Int>, Int>, coinNominal: Int) =
    if (acc.second >= coinNominal) {
        (updateCoinsList(acc, coinNominal) to calculateRemainingAmount(acc, coinNominal))
    } else {
        acc
    }

private fun calculateRemainingAmount(acc: Pair<List<Int>, Int>, coinNominal: Int) =
    acc.second - (coinNominal * (acc.second / coinNominal))

private fun updateCoinsList(acc: Pair<List<Int>, Int>, coinNominal: Int) =
    acc.first + (1..acc.second / coinNominal).map { coinNominal }