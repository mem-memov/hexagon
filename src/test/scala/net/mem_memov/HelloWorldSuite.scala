package net.mem_memov

import cats.effect.{IO, SyncIO}
import munit.CatsEffectSuite
import net.mem_memov.hexagon.HelloWorld

class HelloWorldSuite extends CatsEffectSuite {

  test("test hello world says hi") {
    HelloWorld.say().map(it => assertEquals(it, "Hello Cats!"))
  }
}
