import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { place } from '../place.model';
import { PlacesService } from '../places.service';
import { AlertController } from '@ionic/angular';
import { elementAt } from 'rxjs';




@Component({
  selector: 'app-place-detail',
  templateUrl: './place-detail.page.html',
  styleUrls: ['./place-detail.page.scss'],
})
export class PlaceDetailPage implements OnInit {

  public place: place = { id: '', title: '', imageUrl: '', comments: [] };
  texto_nocomentarios: string = "No hay comentarios todavía ..."

  constructor(private _activatedRouted: ActivatedRoute,
    private placesService: PlacesService,
    private _router: Router,
    private alertCtrl: AlertController) { }

  ngOnInit() {
    this._activatedRouted.paramMap.subscribe(paramMap => {
      const recipeId = paramMap.get('placeID');
      this.place = this.placesService.getPlace(recipeId);
      console.log(this.place)


    })
  }

  async deletePlace() {
    const element = await this.alertCtrl.create(
      {
        header: 'are u sure to delete this Place?',
        message: 'Be careful',
        buttons:
          [
            {
              text: 'Cancel',
              role: 'cancel'
            },
            {
              text: 'Delete',
              handler: () => {
                this.placesService.deletePlace(this.place.id);
                this._router.navigate(['/places'])
              }
            }
          ]
      }
    )
    await element.present();
  };


}
