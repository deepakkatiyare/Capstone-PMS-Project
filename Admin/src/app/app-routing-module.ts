import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { FooterComponent } from "./components/footer/footer.component";
import { HeaderComponent } from "./components/header/header.component";
import { IndexComponent } from "./components/index/index.component";

const routes: Routes = [
    { path: "", redirectTo: "/index", pathMatch: "full" },
    { path: "index", component: HeaderComponent },
    { path: "footer", component: FooterComponent },
    // { path: "**", component: NotFoundComponent },
    { path: "admin", loadChildren: () => import("./modules/admin/admin.module").then((m) => m.AdminModule) }
];
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }