
const RecipeDetails = (props) => {

    if(props.recipe == null ){
        return(
            <div>Please select a recipe to see its details</div>
        )
    }
    else{
        return(
            <div>
                <div>{props.recipe.name}</div>
                {props.recipe.ingredients.map( (ingredient) => {
                    return(
                        <div key={ingredient.index}>
                            <div>{ingredient.amount}</div>
                            <div>{ingredient.unit}</div>
                            <div>{ingredient.name}</div>
                        </div>
                        )})
                }
                {props.recipe.steps.map( (step) => {
                    return(
                        <div key={step.index}>
                            <div>{step}</div>
                        </div>
                    )})
                }
            </div>
        )
    }

}

export default RecipeDetails;