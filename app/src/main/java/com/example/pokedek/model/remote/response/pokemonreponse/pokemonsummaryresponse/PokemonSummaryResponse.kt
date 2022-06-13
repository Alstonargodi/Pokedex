package com.example.pokedek.model.remote.response.pokemonreponse.pokemonsummaryresponse

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class PokemonSummaryResponse(
    @SerializedName("abilities")
    var abilities: List<Ability>,
    @SerializedName("base_experience")
    var baseExperience: Int,
    @SerializedName("forms")
    var forms: List<Form>,
    @SerializedName("game_indices")
    var gameIndices: List<GameIndice>,
    @SerializedName("height")
    var height: Int,
    @SerializedName("held_items")
    var heldItems: List<Any>,
    @SerializedName("id")
    var id: Int,
    @SerializedName("is_default")
    var isDefault: Boolean,
    @SerializedName("location_area_encounters")
    var locationAreaEncounters: String,
    @SerializedName("moves")
    var moves: List<Move>,
    @SerializedName("name")
    var name: String,
    @SerializedName("order")
    var order: Int,
    @SerializedName("past_types")
    var pastTypes: List<Any>,
    @SerializedName("species")
    var species: Species,
    @SerializedName("sprites")
    var sprites: Sprites,
    @SerializedName("stats")
    var stats: List<Stat>,
    @SerializedName("types")
    var types: List<Type>,
    @SerializedName("weight")
    var weight: Int
): Serializable
class Ability(
    @SerializedName("ability")
    var ability: AbilityX,
    @SerializedName("is_hidden")
    var isHidden: Boolean,
    @SerializedName("slot")
    var slot: Int
)
class AbilityX(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)
class Animated(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_female")
    var backFemale: Any,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("back_shiny_female")
    var backShinyFemale: Any,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any
)
class BlackWhite(
    @SerializedName("animated")
    var animated: Animated,
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_female")
    var backFemale: Any,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("back_shiny_female")
    var backShinyFemale: Any,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any
)
class Crystal(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("back_shiny_transparent")
    var backShinyTransparent: String,
    @SerializedName("back_transparent")
    var backTransparent: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_transparent")
    var frontShinyTransparent: String,
    @SerializedName("front_transparent")
    var frontTransparent: String
)
class DiamondPearl(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_female")
    var backFemale: Any,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("back_shiny_female")
    var backShinyFemale: Any,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any
)
class DreamWorld(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any
)
class Emerald(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_shiny")
    var frontShiny: String
)
class FireredLeafgreen(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_shiny")
    var frontShiny: String
)
class GameIndice(
    @SerializedName("game_index")
    var gameIndex: Int,
    @SerializedName("version")
    var version: Version
)
class Form(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)
class GenerationI(
    @SerializedName("red-blue")
    var redBlue: RedBlue,
    @SerializedName("yellow")
    var yellow: Yellow
)
class GenerationIi(
    @SerializedName("crystal")
    var crystal: Crystal,
    @SerializedName("gold")
    var gold: Gold,
    @SerializedName("silver")
    var silver: Silver
)
class GenerationIii(
    @SerializedName("emerald")
    var emerald: Emerald,
    @SerializedName("firered-leafgreen")
    var fireredLeafgreen: FireredLeafgreen,
    @SerializedName("ruby-sapphire")
    var rubySapphire: RubySapphire
)
class GenerationIv(
    @SerializedName("diamond-pearl")
    var diamondPearl: DiamondPearl,
    @SerializedName("heartgold-soulsilver")
    var heartgoldSoulsilver: HeartgoldSoulsilver,
    @SerializedName("platinum")
    var platinum: Platinum
)
class GenerationV(
    @SerializedName("black-white")
    var blackWhite: BlackWhite
)
class GenerationVi(
    @SerializedName("omegaruby-alphasapphire")
    var omegarubyAlphasapphire: OmegarubyAlphasapphire,
    @SerializedName("x-y")
    var xY: XY
)
class GenerationVii(
    @SerializedName("icons")
    var icons: Icons,
    @SerializedName("ultra-sun-ultra-moon")
    var ultraSunUltraMoon: UltraSunUltraMoon
)
class GenerationViii(
    @SerializedName("icons")
    var icons: IconsX
)
class Gold(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_transparent")
    var frontTransparent: String
)
class HeartgoldSoulsilver(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_female")
    var backFemale: Any,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("back_shiny_female")
    var backShinyFemale: Any,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any
)
class Home(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any
)
class Icons(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any
)
class IconsX(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any
)
class Move(
    @SerializedName("move")
    var move: MoveX,
    @SerializedName("version_group_details")
    var versionGroupDetails: List<VersionGroupDetail>
)
class MoveLearnMethod(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)
class MoveX(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)
class OfficialArtwork(
    @SerializedName("front_default")
    var frontDefault: String
)
class OmegarubyAlphasapphire(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any
)
class Other(
    @SerializedName("dream_world")
    var dreamWorld: DreamWorld,
    @SerializedName("home")
    var home: Home,
    @SerializedName("official-artwork")
    var officialArtwork: OfficialArtwork
)
class Platinum(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_female")
    var backFemale: Any,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("back_shiny_female")
    var backShinyFemale: Any,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any
)
class RubySapphire(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_shiny")
    var frontShiny: String
)
class RedBlue(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_gray")
    var backGray: String,
    @SerializedName("back_transparent")
    var backTransparent: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_gray")
    var frontGray: String,
    @SerializedName("front_transparent")
    var frontTransparent: String
)
class Silver(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_transparent")
    var frontTransparent: String
)
class Species(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)
class Sprites(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_female")
    var backFemale: Any,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("back_shiny_female")
    var backShinyFemale: Any,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any,
    @SerializedName("other")
    var other: Other,
    @SerializedName("versions")
    var versions: Versions
)
class Stat(
    @SerializedName("base_stat")
    var baseStat: Int,
    @SerializedName("effort")
    var effort: Int,
    @SerializedName("stat")
    var stat: StatX
)
class StatX(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)
class Type(
    @SerializedName("slot")
    var slot: Int,
    @SerializedName("type")
    var type: TypeX
)
class TypeX(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)
class UltraSunUltraMoon(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any
)
class Version(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)
class VersionGroup(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)
class VersionGroupDetail(
    @SerializedName("level_learned_at")
    var levelLearnedAt: Int,
    @SerializedName("move_learn_method")
    var moveLearnMethod: MoveLearnMethod,
    @SerializedName("version_group")
    var versionGroup: VersionGroup
)
class Versions(
    @SerializedName("generation-i")
    var generationI: GenerationI,
    @SerializedName("generation-ii")
    var generationIi: GenerationIi,
    @SerializedName("generation-iii")
    var generationIii: GenerationIii,
    @SerializedName("generation-iv")
    var generationIv: GenerationIv,
    @SerializedName("generation-v")
    var generationV: GenerationV,
    @SerializedName("generation-vi")
    var generationVi: GenerationVi,
    @SerializedName("generation-vii")
    var generationVii: GenerationVii,
    @SerializedName("generation-viii")
    var generationViii: GenerationViii
)
class XY(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: Any
)
class Yellow(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_gray")
    var backGray: String,
    @SerializedName("back_transparent")
    var backTransparent: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_gray")
    var frontGray: String,
    @SerializedName("front_transparent")
    var frontTransparent: String
)