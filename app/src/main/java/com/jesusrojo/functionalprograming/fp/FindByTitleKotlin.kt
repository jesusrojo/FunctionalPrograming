package com.jesusrojo.functionalprograming.fp

// https://hackernoon.com/functional-programming-by-example-with-kotlin-27fd7e49b55f
// https://github.com/jacquesgiraudel/IntroPgmFonct/commits/master
class FindByTitleKotlin {
    companion object {
;
///////////IMPERATIVE PROGRAMING
//        fun findByTitle(query: String, collection: MutableList<Movie>): List<Movie>{
//            val results: MutableList<Movie> = mutableListOf()
//            do {
//                val movie = collection.removeAt(0)
//                if (movie.title.contains(query)){ results.add(movie) }
//            }
//            while (collection.size > 0)
//            return results
//        }
///////////

/////////////////////////////////STEP 1 - REFACTORING TO PROCEDURAL PROGRAMMING
//        fun findByTitle(query: String, collection: MutableList<Movie>): List<Movie>{
//            val results: MutableList<Movie> = mutableListOf()
//            do {
//                val movie = collection.removeAt(0)
//                addIfMatches(query, movie, results)
//            }
//            while (collection.size > 0)
//            return results
//        }
//        private fun addIfMatches(query: String, movie: Movie, results: MutableList<Movie>){
//            if (matches(query, movie)){ results.add(movie) } TODO - side effects (results can be modified here, outside is local environment)
//        }
//        private fun matches(query: String, movie: Movie): Boolean = title(movie).isInfixOf(query)
//        private fun title(movie: Movie): String = movie.title
//        private fun String.isInfixOf(query: String) = contains(query)
//////////////////////////////////

///////////STEP 3 - MOVING UP THE SIDE EFFECT WITH THE HELP OF FUNCTIONS AS VARIABLES (functions as first class citizen)
//// With this step, we start to use a function like a variable
//// (passed as an argument to other functions,
//// returned by another function or assigned as a value to a variable).
//// This usage is called functions as a first-class citizen
//// A function which takes an other function as argument is called a higher-order function.
//
//        // findByTitle :: (String, [Movie]) -> [Movie]
//        fun findByTitle(query: String, collection: MutableList<Movie>): List<Movie> {
//            val results: MutableList<Movie> = mutableListOf()
//
//            // Use of functions as variables (predicate and add): functions as first class citizen
//
//            // matches :: (String, Film) -> Boolean
//            val predicate = ::matches
//
//            // TODO side effect moved up (still on results)
//            // add :: (Film) -> Boolean
//            val add = fun(movie: Movie) = results.add(movie)
//// add() uses a parameter, results, which is not passed as an argument.
//// This parameter is called a closed parameter and the method a closure.
//// The parameter is said closed because not modifiable by argument,
//// by opposition to an open parameter like those passed as standard method argument
//            for (movie: Movie in collection) {
//                val fn = addIf(predicate, query, movie, add)
//                fn(movie)
//            }
//
//            return results
//        }
//
//        // addIfMatches :: ((String, Movie) -> Boolean, String, Movie, [Movie] -> (Boolean)) -> (Movie) -> (Boolean)
//        fun addIf(
//            predicate: (String, Movie) -> Boolean,
//            query: String,
//            movie: Movie,
//            add: (Movie) -> (Boolean)
//        ): (Movie) -> (Boolean) {
//            if (predicate(query, movie)) {
//                return add
//            }
//            return fun(movie: Movie) = false
//        }
//
//        // matches :: (String, Film) -> Boolean
//        fun matches(query: String, movie: Movie): Boolean = title(movie).isInfixOf(query)
//
//        // title :: (Film) -> String
//        fun title(movie: Movie): String = movie.title
//
//        // isInfixOf :: (String, String) -> Boolean
//        fun String.isInfixOf(query: String) = contains(query)
////////////

/////// STEP 4 - REMOVING THE SIDE EFFECT BY USING THE FUNCTIONAL OPERATOR 'plus' to return a new list (a new state of the list)'
// Finally, the side effect is completely removed by using the plus operator
// which returns another list with the additional movie.

        // findByTitle :: (String, [Movie]) -> [Movie]
        fun findByTitle(query: String, collection: MutableList<Movie>): List<Movie>{
            var results: List<Movie> = listOf()

            // matches :: (String, Film) -> Boolean
            val predicate = ::matches

            // add :: (Film) -> Boolean
            val add = fun (movie: Movie, movies: List<Movie>) = movies.plus(movie)

            for (movie: Movie in collection){
                val fn = addIf(predicate, query, movie, add)
                results = fn(movie, results)
            }

            return results
        }

        // addIfMatches :: ((String, Movie) -> Boolean, String, Movie, [Movie] -> (Boolean)) -> (Movie) -> (Boolean)
        fun addIf(predicate: (String, Movie) -> Boolean, query: String, movie: Movie, add: (Movie, List<Movie>) -> (List<Movie>)): (Movie, List<Movie>) -> (List<Movie>){
            if (predicate(query, movie)){
                return add
            }
            return fun (movie: Movie, movies: List<Movie>) = listOf<Movie>()
        }

        // matches :: (String, Film) -> Boolean
        fun matches(query: String, movie: Movie): Boolean = title(movie).isInfixOf(query)

        // title :: (Film) -> String
        fun title(movie: Movie): String = movie.title

        // isInfixOf :: (String, String) -> Boolean
        fun String.isInfixOf(query: String) = contains(query)


        //First Currying








////////////////////// END
//        var findByTitle: (String) -> (MutableList<Movie>) -> List<Movie> = { query ->
//            { collection ->
//                val predicate = matches(query)
//                filter(predicate)(collection)
//            }
//        }
//
//        val filter: ((Movie) -> Boolean) -> (List<Movie>) -> List<Movie> = { predicate ->
//            { collection ->
//                collection.filter(predicate)
//            }
//        }
//
//        val matches: (String) -> (Movie) -> Boolean =
//            { query -> { movie -> isInfixOf(query)(title(movie)) } }
//
//        val title: (Movie) -> String = { movie -> movie.title }
//
//        val isInfixOf: (String) -> (String) -> Boolean =
//            { query -> { string -> string.contains(query) } }
//////////////////////
    }
}

