package edu.westminsteru.cmpt300f.turtle

enum Command:
  case Forward(distance: Double)
  // add more command types...

object Command:
  private val NUMBER_REGEX = raw"\d+('.'\d*)?" // regular expression for just a number (used in others)

  // Regular expressions for each of the command types
  private val MOVE_REGEX = raw"^(forward|backward) ($NUMBER_REGEX)$$".r
  // add more...

  def parse(text: String): Command = text match
    case MOVE_REGEX("forward", distance) => Forward(distance.toDouble)
    // add more cases...

