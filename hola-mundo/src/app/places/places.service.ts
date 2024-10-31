import { Injectable } from '@angular/core';
import { place } from './place.model';
@Injectable({
  providedIn: 'root'
})
export class PlacesService {

  private places: place[] = [
    {
      id: '1',
      title: 'Torre Eifel',
      imageUrl: 'https://i.pinimg.com/originals/51/a0/72/51a0728076f2cec4eb3d22fee8e36681.jpg',
      comments: ['Maravillosa torre, presiosa', 'uuuh que bonito']
    },
    {
      id: '2',
      title: 'Estatua libertad',
      imageUrl: 'https://i.pinimg.com/originals/51/a0/72/51a0728076f2cec4eb3d22fee8e36681.jpg',
      comments: ['Increible las vistas de la estatua, muuu altaaa o no?'],

    },
    {
      id: '3',
      title: 'Girardillo de Triana',
      imageUrl: 'https://i.pinimg.com/originals/51/a0/72/51a0728076f2cec4eb3d22fee8e36681.jpg',
      comments: [],
    }

  ]

  constructor() { }

  /**
   * getPlaces: recupera un listado de ciudades
   * @returns Array de objetos de ciudades 
   */

  getPlaces() {
    return [...this.places]
  }
/**
 * getPlace: recupera un objeto de tipo ciudad
 * @param placeID (Identificador del objeto de la ciudad a recuperar)
 * @returns (Devuleve un objeto ciudad, recuperado del listado completo de ciudades)
 */
  getPlace(placeID: string|null): place {
    return {
      ...this.places.find(place => {return place.id === placeID})
    }
  }
/**
 * addPlace: Añade una ciudad nueva al listado de ciudades existente
 * @param title (titulo del objeto de nueva ciudad a crear)
 * @param imageUrl (Imagen del objeto de nueva ciudad a crear) 
 */
  addPlace(title: string|undefined, imageUrl: string|undefined) {
    this.places.push({
      title,
      imageUrl,
      comments: [],
      id: (this.places.length + 1).toString()
    })
  }
/**
 * deletePlace: Borra una ciudad  localizada a través de su identificador
 * @param placeID (Identificador de la ciudad a borrar  )
 */
  deletePlace(placeID: string|undefined|null) {
    this.places = this.places.filter(place => {return place.id != placeID })
  }


} 
