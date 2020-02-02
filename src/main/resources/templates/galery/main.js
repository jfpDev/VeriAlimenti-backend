const url = 'http://localhost:8080/db/articles';
//const url = '/db/articles'

function getArticles(){
  let articlesLength;
  fetch(url,{
    method: 'GET',
    headers: {
      'Accept': 'text/html,application/xhtml+xml,application/xml,application/json',
      'Content-Type': 'text/html,application/xhtml+xml,application/xml,application/json',
    }
  })
    .then(res => res.json())
    //.then(data => console.log(Object.entries(data)))
    .then(data => {
      let counter = 0;
      const HTMLarticles = document.getElementById('articlesView');
      articlesLength = data.length;
      while(counter < articlesLength){
        HTMLarticles.innerHTML = `<th>${data[counter].name}<th>`;
        counter++;
      }
    })
    then(data => console.log(data.name))
    .catch(err => console.error(err))
    }
getArticles();
