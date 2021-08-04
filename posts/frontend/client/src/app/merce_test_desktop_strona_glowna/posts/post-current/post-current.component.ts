import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-post-current',
  templateUrl: './post-current.component.html',
  styleUrls: ['./post-current.component.css']
})
export class PostCurrentComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    fetch('https://jsonplaceholder.typicode.com/todos/1')
      .then(response => response.json())
      .then(json => console.log(json))
  }

}
