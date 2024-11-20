data class PokemonResponse(
    val name: String,
    val id: Int,
    val sprites: Sprites
)

data class Sprites(
    val other: Other
)

data class Other(
    val home: Home
)

data class Home(
    val front_default: String
)

data class Pokemon(
    val name: String,
    val id: Int,
    val sprites: Sprites
)