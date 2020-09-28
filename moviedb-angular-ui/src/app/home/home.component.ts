import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormGroup, FormControl, Validators, FormArray } from '@angular/forms';
import { PageConfigService } from '../services/page-config.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  movies :any= [];
  @ViewChild('name') movieName: ElementRef;
  @ViewChild('categoryName') categoryName: ElementRef;
  @ViewChild('year') year: ElementRef;
  @ViewChild('actorName') actorName: ElementRef;
  @ViewChild('directorName') directorName: ElementRef;
  @ViewChild('producerName') producerName: ElementRef;
  constructor(private pageConfigService: PageConfigService) { }
  searchForm: FormGroup;
  ngOnInit(): void {
    this.searchForm = new FormGroup({
      'userData': new FormGroup({
        'name': new FormControl('', Validators.required),
        'categoryName': new FormControl('', Validators.required),
        'year': new FormControl('', Validators.required),
        'actorName': new FormControl('', Validators.required),
        'directorName': new FormControl('', Validators.required),
        'producerName': new FormControl('', Validators.required),
      })
    });
    let inputData ={};
    this.pageConfigService.getMovieData(inputData).subscribe(data => {
      //this.cardList = data['innovation']['cardList'];
      this.movies = data;
      console.log(data);
    });
  }
  onSubmit() {
    let movieName = this.movieName.nativeElement.value;
    let categoryName = this.categoryName.nativeElement.value;
    let year = this.year.nativeElement.value;
    let actorName = this.actorName.nativeElement.value;
    let directorName = this.directorName.nativeElement.value;
    let producerName = this.producerName.nativeElement.value;
    let inputData = {
    movieName : this.movieName.nativeElement.value,
    categoryName : this.categoryName.nativeElement.value,
    year : this.year.nativeElement.value,
    actorName : this.actorName.nativeElement.value,
    directorName : this.directorName.nativeElement.value,
    producerName : this.producerName.nativeElement.value
    };
    this.pageConfigService.getMovieData(inputData).subscribe(data => {
      //this.cardList = data['innovation']['cardList'];
      this.movies = data;
      console.log(data);
    });
   }

}
