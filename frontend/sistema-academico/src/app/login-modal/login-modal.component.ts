import { Component, OnInit, TemplateRef } from '@angular/core';  
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';  

@Component({  
  selector: 'login-modal-popup',  
  templateUrl: './login-modal.component.html',  
  styleUrls: ['./login-modal.component.css']  
})  
export class LoginModalComponent implements OnInit {  
  modalRef: BsModalRef;  
  constructor(private modalService: BsModalService) { }  
  
  ngOnInit() {  
  }  
  openModalWithClass(template: TemplateRef<any>) {  
    this.modalRef = this.modalService.show(  
      template,  
      Object.assign({}, { class: 'gray modal-lg' })  
    );  
  }  
}  