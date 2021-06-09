import { Component, OnInit } from '@angular/core';
import { faFacebook, faInstagram } from '@fortawesome/free-brands-svg-icons';
import { faHeart, faInfoCircle } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-parceiros',
  templateUrl: './parceiros.component.html',
  styleUrls: ['./parceiros.component.css']
})
export class ParceirosComponent implements OnInit{

  constructor() { }

  ngOnInit(): void {
  }
  faFacebook = faFacebook;
  faInstagram = faInstagram;
  faHeart = faHeart;
  faCircleInfo = faInfoCircle

}
