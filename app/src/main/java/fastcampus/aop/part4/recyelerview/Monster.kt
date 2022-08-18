package fastcampus.aop.part4.recyelerview

data class Monster(
    val name: String, //몬스터 이름
    val race: Race, //몬스터 종류 (enum class 활용)
    val level: Int, //몬스터 레벨
    val stats: List<Int>, //몬스터 스탯 HP , MP , Exp
    val encount: Boolean, //몬스터랑 만났는지 안만났는지 체크
)

enum class Race {
    Zombie , Human , Goblin , Dragon
}