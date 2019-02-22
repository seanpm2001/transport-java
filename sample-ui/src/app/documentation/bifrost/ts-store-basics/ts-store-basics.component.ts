import { AfterViewChecked, Component, OnInit } from '@angular/core';
import { BaseBifrostComponent } from '../base.bifrost.component';
import { HighlightService } from '../../../local-services/highlight.service';

@Component({
  selector: 'appfab-ts-store-basics',
  templateUrl: './ts-store-basics.component.html',
  styleUrls: ['./ts-store-basics.component.scss']
})
export class TsStoreBasicsComponent extends BaseBifrostComponent implements OnInit, AfterViewChecked {

    constructor(private highlightService: HighlightService) {
        super('TsStoreBasicsComponent');
    }

    ngOnInit() {
        this.setBifrostTsDocsActive(true);
    }

    ngAfterViewChecked() {
        if (!this.highlighted) {
            this.highlightService.highlightAll();
            this.highlighted = true;
        }
    }
}