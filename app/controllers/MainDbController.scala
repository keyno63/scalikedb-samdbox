package controllers

import play.api.mvc._
import javax.inject.Inject

import scala.concurrent.{ExecutionContext, Future}

class MainDbController @Inject()(
        cc: ControllerComponents
        )(implicit ec: ExecutionContext) extends AbstractController(cc) {

  def main: Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("Ok")
    }
  }

  def main1: Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok("Ok")
    }
  }

}
