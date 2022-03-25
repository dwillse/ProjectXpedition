
const e = require('express');

const locations = [
    {
        id: '1',
        Country: 'Brazil',
        content: 'Visit Lago Azul Grotto, a natural cave formation in the forest of Mato Grosso do Sul, on this 6-hour tour from Bonito. Following your accredited guide, hike down a short path through the forest, learning about the native plants and animals on the way, to the cave.',
        name: "Gruta do Lago Azul",
        category: "Cave"
    },
    {
        id: '2',
        Country: 'Brazil',
        content: 'The Christ the Redeemer statue serves as a symbol for Christianity. The statue is located at the peek of the  Corcovado mountain in the Tijuca National Park.',
        name: "Christ the Redeemer, Rio de Janeiro",
        category: "Historical"
    },
    {
        id: '3',
        Country: 'Brazil',
        content: 'Downtown Rios most fashionable and famous section is bordered all along one side by four kilometers of white sand. The beach is separated from the building and traffic by a broad promenade paved in black and white mosaic in an undulating pattern',
        name: "Copacabana, Rio de Janeiro",
        category: "Beach"
    },
    {
        id: '4',
        Country: 'Brazil',
        content: 'Covering more than 2.1 million square miles of tropical terrain, the Amazon rainforests biodiversity is mind-boggling. Eight of the world’s 20 longest rivers are located in the Amazon basin, where a fifth of Earths freshwater is found.',
        name: "Brazil Jungle Tour",
        category: "Jungle"
    }, 
    {
        id: '5',
        Country: 'Brazil',
        content: 'Legends of stone cities in Brazils rugged interior have circulated for centuries and now you can view them yourself!',
        name: "Inca Ruins",
        category: "Historical"
    }
];

exports.find = function(){
    return locations;
};

