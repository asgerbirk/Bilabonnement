const list = document.querySelectorAll('.navlist');
//vi vælger her alle de elementer vi kunne tænke os at arbejde med og putter dem i en liste som er navngivet, lige som en arraylist

function activator() {
    list.forEach((item) => item.classList.remove('active'));//vi fjerner alle active tokens fra list elementerne i html
    this.classList.add('active'); //her tildeler vi active token til vaglte list item (li segmentet i html)
    //metoden her fjerner alle active tokens fra html listerne med classname som i ovenstående const, og tildeler den bagefter til det valgte liste element
}
    list.forEach((item) => item.addEventListener('click', activator)); //her sørger vi for at
    //her kalder vi metoden på 'click', metoden fjerner alle andre active tokens, og sætter active på den der bliver klikket på.
