const dogSelect = document.getElementById('dog-select')
const vetList = document.getElementById('vet-list')

queryFetch( `
{
  dogs {
    name
    id
    veterinary {
      id
      name
      
    }
  }
}
`)
.then(data => {
    dogSelect.innerHTML=''
    data.data.dogs.forEach(dog => {
        const element = document.createElement('button')
        element.style.width = '100px'
        element.style.height = '100px'
        element.style.background = 'teal'
        element.style.color = 'white'
        element.style.fontSize = '20px'
        element.style.display = 'inline-block'
        element.className= 'form-group'
        element.textContent = dog.name
        element.onclick = async function() {
            const dogId = dog.id
            const vet = await getVetForDog(dogId)
            vetList.innerHTML=''
            const element = document.createElement('div')
            element.innerText = dog.name + " has vet with name " + vet.name
            vetList.append(element)
        }
        dogSelect.appendChild(element)
        const option = document.createElement('option')
        option.value = dog.id
        dogSelect.append(option)
    })
})

function getVetForDog(dogId){
    return queryFetch(`
    query getVetForCode($code:  ID!){
      dogById(id : $code) {
        veterinary {
          name
          
        }
      }
    }

    `, {code: dogId}).then(data => {
        return data.data.dogById.veterinary
    })
}

function queryFetch(query, variables){
    return fetch('http://localhost:8080/graphql', {
        method: 'POST',
        headers: {"Content-Type": "application/json",
        "Access-Control-Allow-Origin": "localhost:8080"},
        body: JSON.stringify({
            query: query,
            variables: variables
        })
    }).then(res => res.json())
}